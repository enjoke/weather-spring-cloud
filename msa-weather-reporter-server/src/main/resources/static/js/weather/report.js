/**
 * report 下拉框实现
 */
$(function(){
    $("#selectProvince").change(function(){
        var province = $("#selectProvince").val();
        var url = "/reporter/index?province=" + province;
        window.location.href = url;
    });
})
$(function(){
    $("#selectCityId").change(function(){
        var province = $("#selectProvince").val();
        var cityName = $("#selectCityId").val();
        var url = "/reporter/" + province + "/" + cityName;
        window.location.href = url;
    });
})