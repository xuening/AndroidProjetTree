package com.example.parcvert;

public class Probleme {
		private int id;
		private String type;
		private float latitude;
		private float longitude;
		private String loc_exacte;
		private String description;
		
		public int getId(){
			return id;
		}
		
		public void setId(int id){
			this.id = id;
		}
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public float getLatitude() {
			return latitude;
		}

		public void setLatitude(float latitude) {
			this.latitude = latitude;
		}
		
		public float getLongitude() {
			return longitude;
		}

		public void setLongitude(float longitude) {
			this.longitude = longitude;
		}
		public String getLoc_exacte() {
			return loc_exacte;
		}

		public void setLoc_exacte(String loc_exacte) {
			this.loc_exacte = loc_exacte;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String original) {
			this.description = description;
		}

		@Override
		public String toString() {
			return "Un problème: " + description +" de type"+ type + ", à la latitude " + latitude + " et la longitude " + longitude + ", et la localisation exacte est " + loc_exacte + ".";
		}
	
}
