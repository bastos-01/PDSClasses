package ex1;

public class Telemovel {

	private double preco;
	private int memoria;
	private int camera;
	private int processador;
	
	public Telemovel(double preco, int memoria, int camera, int processador) {
		this.preco = preco;
		this.memoria = memoria;
		this.camera = camera;
		this.processador = processador;
	}

	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * @return the memoria
	 */
	public int getMemoria() {
		return memoria;
	}

	/**
	 * @param memoria the memoria to set
	 */
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	/**
	 * @return the camera
	 */
	public int getCamera() {
		return camera;
	}

	/**
	 * @param camera the camera to set
	 */
	public void setCamera(int camera) {
		this.camera = camera;
	}

	/**
	 * @return the processador
	 */
	public int getProcessador() {
		return processador;
	}

	/**
	 * @param processador the processador to set
	 */
	public void setProcessador(int processador) {
		this.processador = processador;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Telemovel [preco=" + preco + ", memoria=" + memoria + ", camera=" + camera + ", processador="
				+ processador + "]";
	}
	
	
	
	
	
	

}
