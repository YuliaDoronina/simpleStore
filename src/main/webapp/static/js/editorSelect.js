function getSubcategory() {
    $.getJSON(
        "/listSubcategory",
        {categoryId: $('#category').val()},
        function (data) {
            var options = '';
            options += '<option value="">-----Select-----</option>';
            for (var i = 0; i < data.length; i++) {
                options += '<option value="' + data[i].idSubcategory + '">' + data[i].nameSubcategory + '</option>';
            }
            $('#subcategory').html(options);
            //getProduct();
        }
    );
}

function getProducer() {
    $.getJSON(
        "/listProducer",
        {categoryId: $('#category').val()},
        function (data) {
            var options = '';
            options += '<option value="">-----Select-----</option>';
            for (var i = 0; i < data.length; i++) {
                options += '<option value="' + data[i].idProducer + '">' + data[i].nameProducer + '</option>';
            }
            $('#producer').html(options);
            //getProduct();
        }
    );
}

function getProductBySubcategory() {
    $.getJSON(
        "/listProductByCategory",
        {subcategoryId: $('#subcategory').val()},
        function (data) {
            var options = '';
            for (var i = 0; i < data.length; i++) {
                options += '<option value="' + data[i].idProduct + '">' + "NAME:" + data[i].nameProduct + " PRICE:" + data[i].priceProduct + " DESCRIPTION:" + data[i].descriptionProduct + " FLAG:" + data[i].flagProduct + '</option>';
            }
            $('#product').html(options);
        }
    );
}

function getProductByProducer() {
    $.getJSON(
        "/listProductByProducer",
        {idProducer: $('#producer').val(), idCategory: $('#category').val()},
        function (data) {
            var options = '';
            for (var i = 0; i < data.length; i++) {
                options += '<option value="' + data[i].idProduct + '">' + "NAME:" + data[i].nameProduct + " PRICE:" + data[i].priceProduct + " DESCRIPTION:" + data[i].descriptionProduct + " FLAG:" + data[i].flagProduct + '</option>';
            }
            $('#product').html(options);
        }
    );
}

$(document).ready(function () {
    $('#category').click(function () {
        getSubcategory();
        getProducer();
    });

    $('#subcategory').click(function () {
        getProductBySubcategory();
        $('#producer').prop('selectedIndex', 0);

    });

    $('#producer').click(function () {
        $('#subcategory').prop('selectedIndex', 0);
        getProductByProducer();
    });
});

/*SORTING CATEGORIES*/
$(document).ready(function () {
    $('#btnSortByCategory').click(function () {
        sortByCategory();
    });

    $('#btnSortByPriceProduct').click(function () {
        sortJson('price', true, "/listProductByCategory");
    });

    $('#btnSortByFlagProduct').click(function () {
        sortJson('flag', true);
    });
});

/*1. SORTING CATEGORIES*/
function sortByCategory() {
    $("#category").html($('#category option').sort(function (x, y) {
        return $(x).text() < $(y).text() ? -1 : 1;
    }));
    $("#category").get(0).selectedIndex = 0;

    getSubcategory();
    getProducer();
    getProductByProducer();
   /* $("#product").val("");*/
}

/*2. SORTING PRODUCTS*/
function sortJson(prop, asc, url) {
    $.getJSON(
        url,
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
                options += '<option value="' + data[i].idProduct + '">' + "NAME:" + data[i].nameProduct + " PRICE:" + data[i].priceProduct + " DESCRIPTION:" + data[i].descriptionProduct + " FLAG:" + data[i].flagProduct + '</option>';
            }
            $('#product').html(options);
        }
    );
}


