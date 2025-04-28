package app;

public class Customer {

		private String ageGroup; //young and old
		private String incomeLevel; //high or low
		private String previousPurchases; //none or many
		private String promoInterest;//yes or no
		private String madePurchase; //yes or no
		
		
		public Customer(String ageGroup, String incomeLevel, String previousPurchases, String promoInterest, String madePurchase) {
			this.ageGroup= ageGroup;
			this.incomeLevel= incomeLevel;
			this.previousPurchases= previousPurchases;
			this.promoInterest= promoInterest;
			this.madePurchase= madePurchase;
			
		}
		
		
		//getters
		public String getAgeGroup() {
			return ageGroup;
					
		}
		
		public String getIncomeLevel() {
			return incomeLevel;
		}
		
		public String getPreviousPurchases() {
			return previousPurchases;
		}
		
		public String getPromoInterest() {
			return promoInterest;
			
		}
		
		public String getMadePurchase() {
			return madePurchase;
		}
		
		
}
