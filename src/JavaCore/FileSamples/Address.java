package JavaCore.FileSamples;

public class Address {
    private int houseNo;
    private String streetName;
    private String city;
    private int pinCode;

    public Address(int houseNo, String streetName, String city, int pinCode) {
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.city = city;
        this.pinCode = pinCode;
    }

    public String getAddress() {
        return houseNo + ", " + streetName + ", "
                + city + ", " + pinCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result =1 ;
         result = prime * result + houseNo;
         result = prime * result + ((streetName == null ) ? 0 : streetName.hashCode());
         result = prime * result + ((city == null ) ? 0 : city.hashCode());
         result = prime * result + pinCode;

         return result;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return  false;
        if(getClass() != obj.getClass()) return  false;
        Address other = (Address) obj;
        if(houseNo != other.houseNo) return false;
        if(pinCode != other.pinCode) return false;
        if(streetName == null) {
            if(other.streetName != null) return false;
        } else if(!city.equals(other.city)) return false;
        return true;
    }
}
