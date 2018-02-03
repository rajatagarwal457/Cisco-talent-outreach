<<<<<<< HEAD
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
=======
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
>>>>>>> 76c10b4b0a8129cada86eb3e78ad559335656ccc
