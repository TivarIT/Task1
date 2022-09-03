import com.fasterxml.jackson.annotation.JsonProperty;
//POJO
public class Address {
    @JsonProperty("city")
    public String getCity() {
        return this.city; }
    public void setCity(String city) {
        this.city = city; }
    String city;
    @JsonProperty("street")
    public String getStreet() {
        return this.street; }
    public void setStreet(String street) {
        this.street = street; }
    String street;
    @JsonProperty("building")
    public int getBuilding() {
        return this.building; }
    public void setBuilding(int building) {
        this.building = building; }
    int building;
}
