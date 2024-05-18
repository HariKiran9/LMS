package designPatterns.decorator.design.factory;

public interface Report {
	public Object[][] getReportData(final String reportId);

	public String getFirstColumnData();

}
