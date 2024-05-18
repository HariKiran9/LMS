package designPatterns.decorator.design.factory;

public class DecoratorPatternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
         
        SupportPopupDecorator supportPopupDecoratored = new SupportPopupDecorator(new SupportLinkDecorator(new SupportReport()));
        System.out.println(supportPopupDecoratored.getFirstColumnData());

	}

}
