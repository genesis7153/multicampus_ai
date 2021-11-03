package com.example.sba.dto;

public class CelebrityFace {
	private Info info;
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public static class Info{
		private Size size;
		
		public Size getSize() {
			return size;
		}

		public void setSize(Size size) {
			this.size = size;
		}

		public static class Size{
			private int width;
			private int height;
			public int getWidth() {
				return width;
			}
			public void setWidth(int width) {
				this.width = width;
			}
			public int getHeight() {
				return height;
			}
			public void setHeight(int height) {
				this.height = height;
			}
		}
		private int faceCount;

		public int getFaceCount() {
			return faceCount;
		}

		public void setFaceCount(int faceCount) {
			this.faceCount = faceCount;
		}
		private Faces[] faces;
		
		public Faces[] getFaces() {
			return faces;
		}

		public void setFaces(Faces[] faces) {
			this.faces = faces;
		}

		public static class Faces{
			private Celebrity celebrity;
			
			public Celebrity getCelebrity() {
				return celebrity;
			}

			public void setCelebrity(Celebrity celebrity) {
				this.celebrity = celebrity;
			}

			public static class Celebrity{
				private String value;
				private double confidence;
				public String getValue() {
					return value;
				}
				public void setValue(String value) {
					this.value = value;
				}
				public double getConfidence() {
					return confidence;
				}
				public void setConfidence(double confidence) {
					this.confidence = confidence;
				}
				
			}
		}
		
	}
}
