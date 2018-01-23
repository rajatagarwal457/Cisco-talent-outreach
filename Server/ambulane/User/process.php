<?php

class process {

	function declareArray(){
		$response = array();
		$response["NotificationCheck"] = false;
	}

	function entrylog(){
		if(1){
			echo json_encode("  *** process.php running *** ");
		}
	}

	function __construct() {
		// connecting to database
		$this->connect();
	}

	function __destruct() {
		$this->close();
	}

	/**
	* Calculates the great-circle distance between two points, with
	* the Haversine formula.
	* @param float $latitudeFrom Latitude of start point in [deg decimal]
	* @param float $longitudeFrom Longitude of start point in [deg decimal]
	* @param float $latitudeTo Latitude of target point in [deg decimal]
	* @param float $longitudeTo Longitude of target point in [deg decimal]
	* @param float $earthRadius Mean earth radius in [m]
	* @return float Distance between points in [m] (same as earthRadius)
	*/
	function haversineGreatCircleDistance(
		$latitudeFrom, $longitudeFrom, $latitudeTo, $longitudeTo, $earthRadius = 6371000)
		{
			// convert from degrees to radians
			$latFrom = deg2rad($latitudeFrom);
			$lonFrom = deg2rad($longitudeFrom);
			$latTo = deg2rad($latitudeTo);
			$lonTo = deg2rad($longitudeTo);

			$latDelta = $latTo - $latFrom;
			$lonDelta = $lonTo - $lonFrom;

			$angle = 2 * asin(sqrt(pow(sin($latDelta / 2), 2) +
			cos($latFrom) * cos($latTo) * pow(sin($lonDelta / 2), 2)));
			return $angle * $earthRadius;
		}

		function connect() {

			global $conn;
			$AmbulanceNo = 1;
			$c_id = 1;
			include_once 'C:\xampp\htdocs\ambulane\Config.php';

			// Connect to the server
			$conn = mysqli_connect(DB_HOST, DB_USERNAME, DB_PASSWORD);

			if (!$conn) {
				echo json_encode(" *** dbConn Conn Failed :( ***");
			}
			else {
				echo json_encode(" *** dbConn Conn Success :) ***");
			}

			// Connect to the DB
			if (!mysqli_select_db($conn,DB_NAME)) {
				echo json_encode(" *** dbConn DB Failed :( ***");
			}
			else {
				echo json_encode(" *** dbConn DB Success :) ***");
			}
			//debug
			/*
			if(1){
			echo json_encode("NotifCheck");

			$response["NotificationCheck"] ="true";
			print_r(json_encode($response));

			$response["NotificationCheck"] = "false";
		} */

		//while(1) {

			sleep(5);
			//list of ambulance with status ==ON
			$data = "SELECT * FROM `location` WHERE 1";
			$query = mysqli_query($conn, $data);

			if( mysqli_num_rows($query) > 0 ) {
				$member = mysqli_fetch_assoc($query);
				$mAmbulanceNo = $member['AmbulanceNo'];
				$latitude =  $member['Latitude'];
				$longitude =  $member['Longitude'];
				$bearing = $member['Bearing'];

				$data_client = "SELECT * FROM `client` WHERE 1";
				$query_client = mysqli_query($conn, $data_client);

				if( mysqli_num_rows($query_client) > 0 ) {
					$member_client = mysqli_fetch_assoc($query_client);
					while( $member_client != NULL ) {
						$c_id = $member_client['c_id'];
						$c_latitude =  $member_client['Latitude'];
						$c_longitude =  $member_client['Longitude'];
						$c_bearing = $member_client['Bearing'];

						$c_bearing = (int) ($c_bearing);
						$bearing = (int) ($bearing);

						$c_bearing = 100;
						$bearing = 100;

						//echo json_encode("before");
						//echo json_encode($c_bearing);
						//echo json_encode($bearing);
						if( $c_bearing - $bearing <= 10 && $c_bearing - $bearing >= -10) {

							//echo json_encode("after");
							$distance = $this ->haversineGreatCircleDistance( $latitude, $longitude, $c_latitude, $c_longitude );
							if($distance <=1000) {

								$response["NotificationCheck"] ="true";

								header('Content-type: application/json');
								echo json_encode($response);

								$response["NotificationCheck"] = "false";
								break;
							}
						} else {
							echo json_encode("failed");
						}
					}
				}
			}
		//}
		return $conn;
	}
	// Close function
	function close() {
		// close db connection
		mysqli_close($conn = mysqli_connect(DB_HOST, DB_USERNAME, DB_PASSWORD));
	}
}
?>
