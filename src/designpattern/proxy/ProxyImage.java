package designpattern.proxy;

public class ProxyImage implements Image {

	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		System.out.println("[ProxyImage] [ProxyImage] Loading " + fileName);
		this.fileName = fileName;
	}

	@Override
	public void display() {
		System.out.println("[ProxyImage] display()" + fileName);
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}

}
