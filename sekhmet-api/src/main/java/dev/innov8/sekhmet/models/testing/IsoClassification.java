package dev.innov8.sekhmet.models.testing;

public class IsoClassification {

	private int level;
	private double nonViableParticleLimit_0p5;
	private double nonViableParticleLimit_1p0;
	private double nonViableParticleLimit_5p0;
	
	public IsoClassification(int level, double nvpc_0p5, double nvpc_1p0, double nvpc_5p0) {
		super();
		this.level = level;
		this.nonViableParticleLimit_0p5 = nvpc_0p5;
		this.nonViableParticleLimit_1p0 = nvpc_1p0;
		this.nonViableParticleLimit_5p0 = nvpc_5p0;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (level > 9) level = 9;
		else if (level < 1) level = 1;
		this.level = level;
	}

	public double getNonViableParticleLimit_0p5() {
		return nonViableParticleLimit_0p5;
	}

	public void setNonViableParticleLimit_0p5(double nvpc_0p5) {
		this.nonViableParticleLimit_0p5 = nvpc_0p5;
	}

	public double getNonViableParticleLimit_1p0() {
		return nonViableParticleLimit_1p0;
	}

	public void setNonViableParticleLimit_1p0(double nvpc_1p0) {
		this.nonViableParticleLimit_1p0 = nvpc_1p0;
	}

	public double getNonViableParticleLimit_5p0() {
		return nonViableParticleLimit_5p0;
	}

	public void setNonViableParticleLimit_5p0(double nvpc_5p0) {
		this.nonViableParticleLimit_5p0 = nvpc_5p0;
	}
	
	
	
}
