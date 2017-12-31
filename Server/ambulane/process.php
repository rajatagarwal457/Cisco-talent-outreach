<?php
//include_once __DIR__.'/vendor/autoload.php';
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
		include_once dirname(__FILE__) . './Config.php';

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
		if(1){
			echo json_encode("NotifCheck");

			$response["NotificationCheck"] ="true";
			print_r(json_encode($response));

			$response["NotificationCheck"] = "false";
		} /*
		while(1) {
			//list of ambulance with status ==ON
			$data = "select * from location where status='ON' ";

			$query = mysqli_query($conn, $data);

			if( mysqli_num_rows($query) > 0 ) {
				$member = mysqli_fetch_assoc($query);
				$mAmbulanceNo = $member['AmbulanceNo'];
				$latitude =  $member['Latitude'];
				$longitude =  $member['Longitude'];
				$bearing = $member['Bearing'];

				$data_client = "select * from client";

				$query_client = mysqli_query($data_client);
				if( mysqli_num_rows($query_client) > 0 ) {
					while( $member_client = mysqli_fetch_assoc($query_client) ) {
						$c_id = $member_client['c_id'];
						$c_latitude =  $member_client['Latitude'];
						$c_longitude =  $member_client['Longitude'];
						$c_bearing = $member_client['Bearing'];

						if( $c_bearing - $bearing <= 10 && $c_bearing - $bearing >= -10) {
							$distance = $this ->haversineGreatCircleDistance( $latitude, $longitude, $c_latitude, $c_longitude );
							if($distance <=1000 && $distance > 100 ) {
								/*
								$response["NotificationCheck"] ="true";

								echo json_encode($response);

								$response["NotificationCheck"] = "false";
							}
						}
					}
				}
			}
		}
		*/
		return $conn;
	}
		// Close function
	function close() {
		// close db connection
		mysqli_close($conn = mysqli_connect(DB_HOST, DB_USERNAME, DB_PASSWORD));
	}

}
?>
