

public class LinearRegression {
	private double[] xData;
	private double[] yData;
	
	public LinearRegression(double[] xData, double[] yData){
		this.xData = xData;
		this.yData = yData;
	}
	
	public int predictForValue(int predictForDependentVariable) { //"horrible name" from Trish
		//preliminary work
		//verify the data sets are correct
		if(xData.length != yData.length)
			throw new IllegalStateException("Datasets must be equal is size");
		int nValues = xData.length;
		
		//task 1: sum x data and y data
		double sumXData = 0.0;
		double sumYData = 0.0;
		for(int i = 0; i < xData.length; i++) {
			sumXData += xData[i];
			sumYData += yData[i];
		}
		
		//task 2: compute the mean of the x data values and the y data values
		double xDataBar = sumXData/nValues;
		double yDataBar = sumYData/nValues;
		
		//task 3:compute the least squares regression line
		//subtract the x mean values from the x data values and square it
		double xxBar = 0.0;
		double xyBar = 0.0;
		for(int i = 0; i<nValues; i++) {
			xxBar += (xData[i] - xDataBar) * (xData[i] - xDataBar);
			xyBar += (xData[i] - xDataBar) * (yData[i] - yDataBar);
		}
		
		//task 4: compute the slope and the intercept
		double slope = xyBar/xxBar;
		double intercept = yDataBar - slope * xDataBar;
		
		//task 5: compute the prediction
		return (int) (intercept + slope * predictForDependentVariable);
	}
}
