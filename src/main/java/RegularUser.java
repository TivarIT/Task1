import com.fasterxml.jackson.annotation.JsonProperty;

//POJO
public class RegularUser {
    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    int id;
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    @JsonProperty("address")
    public Address getAddress() {
        return this.address; }
    public void setAddress(Address address) {
        this.address = address; }
    Address address;
}

