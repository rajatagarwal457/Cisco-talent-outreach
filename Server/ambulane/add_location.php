<?php
include_once './dbConnect.php';
include_once './process.php';
function AddUserLocation() {
        $response = array();
        $mLatitude = $_POST["mLatitude"];
        $mLongitude = $_POST["mLongitude"];
        $mBearing = $_POST["mBearing"];
        $db = new dbConnect();
        $process = new process();
}
AddUserLocation();
?>
