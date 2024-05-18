package designPatterns.decorator.design.factory;

public abstract class ColumDecorator implements Report {

	private Report decoratedReport;

	public ColumDecorator(Report report) {
		this.decoratedReport = report;
	}

	@Override
	public Object[][] getReportData(String reportId) {
		return decoratedReport.getReportData(reportId);
	}

	@Override
	public String getFirstColumnData() {
		return decoratedReport.getFirstColumnData();
	}

}
