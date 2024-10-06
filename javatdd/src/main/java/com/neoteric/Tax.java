package com.neoteric;

public class Tax {
    public class ITRFormSelector {
        public int annualIncome;
        public boolean hasMultipleProperties;
        public boolean hasOtherHouse;
        public boolean hasSaleOfInvestment;
        public boolean hasForeignSources;
        public boolean hasAgricultureIncome;
        public boolean isPartnershipFirmIncome;
        public boolean isBusinessProfessionIncome;
        public boolean hasPresumptiveIncome;
        public boolean isFirm;

        public ITRFormSelector(int annualIncome) {

            this.annualIncome = annualIncome;

        }

    }
}
