function getSubcategory() {
    $.getJSON(
        "/listSubcategory",
        {categoryId: $('#category').val()},
        function (data) {
            var options = '';
            for (var i = 0; i < data.length; i++) {
                options += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
            }
            $('#subcategory').html(options);

            //getProduct();
        }
    );
}

function getProduct(url, x) {
    $.getJSON(
        url,
        {id: $(x).val()},
        function (data) {
            var options = '';
            for (var i = 0; i < data.length; i++) {
                options += '<option value="' + data[i].id + '">' + "NAME:" + data[i].name + " PRICE:" + data[i].price + " DESCRIPTION:" + data[i].description + " FLAG:" + data[i].flag + '</option>';
            }
            $('#product').html(options);
        }
    );
}

function getProducer() {
    $.getJSON(
        "/listProducer",
        {categoryId: $('#category').val()},
        function (data) {
            var options = '';
            for (var i = 0; i < data.length; i++) {
                options += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
            }
            $('#producer').html(options);

            //getProduct();
        }
    );
}

$(document).ready(function () {
    $('#category').change(function () {
        getSubcategory();
        getProducer();
    });

    $('#category').click(function () {
        $('#subcategory').show(1000);
    });

    $('#subcategory').change(function () {
        getProduct("/listProductByCategory", '#subcategory');
    });

    $('#subcategory').click(function () {
        $('#category').show(1000);
    });

    $('#producer').click(function () {
        getProduct("/listProductByProducer", '#producer');
    });

});

/*SORTING CATEGORIES*/
$(document).ready(function () {
    $('#btnSort').click(function () {
        $("#category").html($('#category option').sort(function (x, y) {
            return $(x).text() < $(y).text() ? -1 : 1;
        }));
        $("#category").get(0).selectedIndex = 0;

        getSubcategory();
        getProduct();
    });
});


/*SORTING PRODUCTS*/
function sortJson(prop, asc) {
    $.getJSON(
        "/listProduct",
        {subcategoryId: $('#subcategory').val()},
        function (data) {
            data = data.sort(function (a, b) {
                switch (prop) {
                    case 'price':
                        var floatA = parseFloat(a[prop]);
                        var floatB = parseFloat(b[prop]);
                        if (asc) {
                            return (floatA > floatB) ? 1 : -1;
                        }
                        return floatA - floatB;
                        break;
                    case 'flag':
                        return (a[prop] === b[prop]) ? 0 : a[prop] ? -1 : 1;
                }
            });

            var options = '';
            for (var i = 0; i < data.length; i++) {
                options += '<option value="' + data[i].id + '">' + "NAME:" + data[i].name + " PRICE:" + data[i].price + " DESCRIPTION:" + data[i].description + " FLAG:" + data[i].flag + '</option>';
            }
            $('#product').html(options);
        }
    );
}

$(function () {
    $('#btnSortByPriceProduct').click(function () {
        sortJson('price', true);
    });

    $('#btnSortByFlagProduct').click(function () {
        sortJson('flag', true);
    });
});