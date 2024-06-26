/**
 * 
 */
package techgig;

import java.text.DecimalFormat;

/**
 * @author Hari Kiran
 *
 */
public class SunTechTester2 {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		// String input = "10,10,5,2,2,3,1,14,25";
		System.out.println(get_total_profit());
	}

	public static String get_total_profit() {
		// String[] inputs = input1.split(",");
		// Piece of farm land in square kilometer
//		Scanner in = new Scanner(System.in);
//		float L = in.nextInt(); // Float.valueOf(inputs[0]);
		// Fertilizer in kg
//		float F = in.nextInt();// Float.valueOf(inputs[1]);
		// Insecticide in kg
//		float P = in.nextInt();// Float.valueOf(inputs[2]);
		// Fertilizer required in kg for square kilometer of Wheat
//		float F1 = in.nextInt();// Float.valueOf(inputs[3]);
		// Insecticide required in kg for square kilometer of Wheat
//		float P1 = in.nextInt();// Float.valueOf(inputs[4]);
		// Fertilizer required in kg for square kilometer of Rice
//		float F2 = in.nextInt();// Float.valueOf(inputs[5]);
		// Insecticide required in kg for square kilometer of Rice
//		float P2 = in.nextInt();// Float.valueOf(inputs[6]);
		// Selling price of wheat per square kilometer
//		float S1 = in.nextInt();// Float.valueOf(inputs[7]);
		// Selling price of rice per square kilometer
//		float S2 = in.nextInt();// Float.valueOf(inputs[8]);

		// let us say that L = 10 Km2 , F = 10 Kg, P = 5 Kg, F1 = 2 Kg, P1 = 2 Kg, F2 =
		// 3 Kg, P2 = 1 Kg, S1 = 14 , S2 = 25

		float L = 10; // Float.valueOf(inputs[0]);
		// Fertilizer in kg
		float F = 10;// Float.valueOf(inputs[1]);
		// Insecticide in kg
		float P = 5;// Float.valueOf(inputs[2]);
		// Fertilizer required in kg for square kilometer of Wheat
		float F1 = 2;// Float.valueOf(inputs[3]);
		// Insecticide required in kg for square kilometer of Wheat
		float P1 = 2;// Float.valueOf(inputs[4]);
		// Fertilizer required in kg for square kilometer of Rice
		float F2 = 3;// Float.valueOf(inputs[5]);
		// Insecticide required in kg for square kilometer of Rice
		float P2 = 1;// Float.valueOf(inputs[6]);
		// Selling price of wheat per square kilometer
		float S1 = 14;// Float.valueOf(inputs[7]);
		// Selling price of rice per square kilometer
		float S2 = 25;// Float.valueOf(inputs[8]);

		// Result Variables
		float totalRiceInsecUsed = 0f;
		float totalRiceFertUsed = 0f;
		float totalWheatInsecUsed = 0f;
		float totalWheatFertUsed = 0f;
		float areaOfWheat = 0.00f;
		float areaOfRice = 0.00f;
		float amount = 0.00f;

		while (true) {
			if ((L == areaOfRice + areaOfWheat) || P == totalRiceInsecUsed + totalWheatInsecUsed
					|| F == totalRiceFertUsed + totalWheatFertUsed || F2 == 0 || F1 == 0 || P2 == 0 || P1 == 0) {
				break;
			}

			float calRiceProfit = Math.min(F / F2, P / P2) * S2;
			float calWheatProfit = Math.min(F / F1, P / P1) * S1;

			if (calRiceProfit > calWheatProfit) {
				float areaInsecUsed = P / P2;
				float areaFertUsed = F / F2;
				if (areaInsecUsed > areaFertUsed) {
					L = L - areaFertUsed;
					F2 = 0;
					totalRiceFertUsed = totalRiceFertUsed + F2;
					areaOfRice = areaOfRice + areaFertUsed;
					amount = amount + areaFertUsed * S2;
				} else if (areaInsecUsed < areaFertUsed) {
					L = L - areaInsecUsed;
					P2 = 0;
					totalRiceInsecUsed = totalRiceInsecUsed + areaInsecUsed;
					areaOfRice = areaOfRice + areaInsecUsed;
					amount = amount + areaInsecUsed * S2;
				}
			} else {
				float areaInsecUsed = P / P1;
				float areaFertUsed = F / F1;
				if (areaInsecUsed > areaFertUsed) {
					L = L - areaFertUsed;
					F1 = 0;
					totalWheatFertUsed = totalWheatFertUsed + F1;
					areaOfWheat = areaOfWheat + areaFertUsed;
					amount = amount + areaFertUsed * S1;
				} else if (areaInsecUsed < areaFertUsed) {
					L = L - areaInsecUsed;
					P1 = 0;
					totalWheatInsecUsed = totalWheatInsecUsed + areaInsecUsed;
					areaOfWheat = areaOfWheat + areaInsecUsed;
					amount = amount + areaInsecUsed * S1;
				}
			}

		}
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		return df.format(amount) + "," + df.format(areaOfWheat) + "," + df.format(areaOfRice);
	}

}
