<?php
class dbConnectDriver {

	function __construct() {
		// connecting to database
		$this->connect();
	}
	function __destruct() {
		$this->close();
	}
	function connect() {

		global $conn;
		include_once 'C:\xampp\htdocs\ambulane\Config.php';

		$response = array();
		$mLatitude = $_POST["mLatitude"];
		$mLongitude = $_POST["mLongitude"];
		$mBearing = $_POST["mBearing"];
		$mAmbulanceNo = 1;

		echo json_encode($mLatitude);
		echo json_encode($mLongitude);
		echo json_encode($mBearing);

		// Connect to the server
		$conn = mysqli_connect(DB_HOST, DB_USERNAME, DB_PASSWORD);

		if (!$conn) {
			echo json_encode(" *** dbConn Conn Failed ***");
		}
		else {
			echo json_encode(" *** dbConn Conn Success :) ***");
		}

		// Connect to the DB
		if (!mysqli_select_db($conn,DB_NAME)) {
			echo json_encode(" *** dbConn DB Failed ***");
		}
		else {
			echo json_encode(" *** dbConn DB Success ***");
		}

		$mLatitude = mysqli_real_escape_string($conn, $mLatitude);
		$mLongitude = mysqli_real_escape_string($conn, $mLongitude);
		$mBearing = mysqli_real_escape_string($conn, $mBearing);

		echo json_encode($mLatitude);
		echo json_encode($mLongitude);
		echo json_encode($mBearing);

		$data = "select * from location where AmbulanceNo='$mAmbulanceNo' ";

		$query = mysqli_query($conn, $data);

		if( mysqli_num_rows($query) > 0 ) {

			while( $member = mysqli_fetch_assoc($query) ) {
				/*
				$lat_old = $member['Latitude'];
				$long_old = $member['Longitude'];
				$bearing_old = $member['Bearing'];
				//move old data
				$qry = "UPDATE location SET Lat_old =  '$lat_old', Long_old =  '$long_old', Bearing_old ='$bearing_old' WHERE AmbulanceNo='$mAmbulanceNo'" ;

				$result=mysqli_query($conn, $qry);
				if(!$result) {
					echo json_encode(" query failed");
				}  */
				// update new data
				$qry_new = "UPDATE location SET Latitude =  '$mLatitude', Longitude =  '$mLongitude', Bearing = '$mBearing'  WHERE AmbulanceNo='$mAmbulanceNo'" ;

				$result_new = mysqli_query($conn, $qry_new);
				if($result_new) {
				}
			}
		} else {
			//add new set if no ambulance data is present
			$result = mysqli_query($this->conn,"INSERT INTO location(AmbulanceNo,Latitude,Longitude,Bearing) VALUES($mAmbulanceNo,'$mLatitude','$mLongitude','$mBearing')");

			if ($result) {
				$response["error"] = false;
				$response["message"] = " Location added successfully";
			} else {
				echo json_encode(mysqli_error($conn));
				echo json_encode(mysqli_sqlstate($conn));

				$response["error"] = true;
				$response["message"] = " Failed to add location";
			}
			// echo json response
			echo json_encode($response);
		}

		// Run query
		return $conn;
	}
	// Close function
	function close() {
		// close db connection
		mysqli_close(mysqli_connect(DB_HOST, DB_USERNAME, DB_PASSWORD));
	}
}
?>
