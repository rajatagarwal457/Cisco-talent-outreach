<<<<<<< HEAD
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
=======
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
>>>>>>> 76c10b4b0a8129cada86eb3e78ad559335656ccc
