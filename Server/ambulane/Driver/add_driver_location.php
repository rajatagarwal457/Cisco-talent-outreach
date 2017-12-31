<?php
include_once './dbConnect_driver.php';
function AddDriverLocation() {
        $response = array();
        $mLatitude = $_POST["mLatitude"];
        $mLongitude = $_POST["mLongitude"];
        $mBearing = $_POST["mBearing"];
        $db = new dbConnectDriver();
}
AddDriverLocation();
?>
