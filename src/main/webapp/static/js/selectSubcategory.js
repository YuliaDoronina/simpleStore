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
        }
    );
}

$(document).ready(function () {
    $('#category').change(function () {
        getSubcategory();
    });
});