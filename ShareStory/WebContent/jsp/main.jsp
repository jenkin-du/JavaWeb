<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="initial-scale=1, maximum-scale=1,user-scalable=no"/>
    <title>图片分享系统</title>
    <link rel="stylesheet"
          href="http://127.0.0.1:8080/arcgis_js_api/library/4.3/4.3/dijit/themes/claro/claro.css"/>
    <link rel="stylesheet"
          href="http://127.0.0.1:8080/arcgis_js_api/library/4.3/4.3/esri/css/main.css"/>
    <!-- For-Mobile-Apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Classy Forms Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up
        Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template,
        Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design"/>
    <script type="application/x-javascript">


        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);
        function hideURLbar() {
            window.scrollTo(0, 1);
        }


    </script>
    <!-- //For-Mobile-Apps -->
    <style>
        html, body, #ui-map-view {
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100%;
        }
    </style>
    <script
            src="http://127.0.0.1:8080/arcgis_js_api/library/4.3/4.3/init.js"></script>
</head>
<body>
<!-- class="claro" -->
<div id="map-view" style="width: 800px; height: 600px"></div>
</body>
<%
    /* String username = request.getParameter("username");
    session.setAttribute("username", username); */
%>

<script>
    var myMap, view, graphicLayer;
    require(
        ["esri/tasks/Locator", "esri/Basemap", "esri/layers/TileLayer",
            "esri/Map", "esri/views/MapView", "esri/views/ui/UI",
            "esri/symbols/SimpleMarkerSymbol",
            "esri/geometry/SpatialReference", "esri/geometry/Point",
            "esri/layers/GraphicsLayer", "esri/Graphic", "esri/Color",
            "dojo/domReady!"],
        function (Locator, Basemap, TileLayer, Map, MapView, UI,
                  SimpleMarkerSymbol, SpatialReference, Point, GraphicsLayer,
                  Graphic, Color) {
            // --------------------------------------------------------------------
            // If you do not have public Internet access then use the Basemap class
            // and point this URL to your own locally accessible cached service.
            //
            // Otherwise you can just use one of the named hosted ArcGIS services.
            // --------------------------------------------------------------------
            var layer = new TileLayer(
                {
                    url: "http://cache1.arcgisonline.cn/arcgis/rest/services/ChinaOnlineCommunity/MapServer"
                });

            var customBasemap = new Basemap({
                baseLayers: [layer],
                title: "Custom Basemap",
                id: "myBasemap"
            });
            myMap = new Map({
                basemap: customBasemap
            });
            view = new MapView({
                center: [118.930828, 32.113681], // long, lat
                container: "map-view",
                map: myMap,
                zoom: 15

            });

            //设置地图坐标系类型
            // var spatialReference = new SpatialReference(102100);
            // map.spatialReference = spatialReference;
            // 创建图层
            graphicLayer = new GraphicsLayer();
            //把图层添加到地图上
            myMap.add(graphicLayer);
            //添加Marker

            view.on("click", function (event) {

                // addMarker(event.mapPoint.latitude, event.mapPoint.longitude);
                //设置标注的经纬度
                var pt = new Point(event.mapPoint.latitude,
                    event.mapPoint.longitude, myMap.spatialReference);
                var symbol = new SimpleMarkerSymbol({
                    style: "square",
                    color: "green",
                    size: "18px", // pixels
                    outline: { // autocasts as esri/symbols/SimpleLineSymbol
                        color: [255, 255, 0],
                        width: 1
                        // points
                    }
                });
                //创建图像
                var graphic = new Graphic(pt, symbol);
                //把图像添加到刚才创建的图层上
                graphicLayer.add(graphic);

            });
            myMap.showZoomSlider();

            // addMarker(118.930828, 32.113681);
            /* function addMarker(xx, yy) {


             } */
        });
</script>
</html>
