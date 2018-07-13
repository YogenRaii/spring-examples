package com.eprogrammerz.examples.config;

public class PropertyParts<S1, S2, S3> {

	private S1 one;
	private S2 two;
	private S3 three;

	PropertyParts(S1 one, S2 two, S3 three) {
		this.one = one;
		this.two = two;
		this.three = three;
	}

	public S1 getPartOne() {
		return this.one;
	}

	public S2 getPartTwo() {
		return this.two;
	}

	public S3 getPartThree() {
		return this.three;
	}

	public void setPartOne(S1 one) {
		this.one = one;
	}

	public void setPartTwo(S2 two) {
		this.two = two;
	}

	public void setPartThree(S3 three) {
		this.three = three;
	}

	@Override
	public int hashCode() {
		return one.hashCode() ^ two.hashCode() ^ three.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof PropertyParts<?, ?, ?>)) {
			@SuppressWarnings("unchecked")
			PropertyParts<S1, S2, S3> parto = (PropertyParts<S1, S2, S3>) o;
			return this.one.equals(parto.getPartOne()) && this.two.equals(parto.getPartTwo())
					&& this.three.equals((parto.getPartThree()));
		} else {
			return false;
		}
	}
}
