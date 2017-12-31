<?php
include_once './dbConnect_User.php';
include_once './process.php';
function AddUserLocation() {
        $response = array();
        $mLatitude = $_POST["mLatitude"];
        $mLongitude = $_POST["mLongitude"];
        $mBearing = $_POST["mBearing"];
        $db = new dbConnectUser();
        $process = new process();
}
AddUserLocation();
?>
