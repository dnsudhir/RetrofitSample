package qubag.com.retrofitsample;

public class Customer {

  private int account_id;
  private int cust_id_fk;
  private String bill_amount;
  private String credit;
  private String qubag_money;
  private int cust_id;
  private String title;
  private String name;
  private String phone_no;
  private String alternate_contact;
  private String email;
  private String created_date;

  public int getAccount_id() {
    return account_id;
  }

  public void setAccount_id(int account_id) {
    this.account_id = account_id;
  }

  public int getCust_id_fk() {
    return cust_id_fk;
  }

  public void setCust_id_fk(int cust_id_fk) {
    this.cust_id_fk = cust_id_fk;
  }

  public String getBill_amount() {
    return bill_amount;
  }

  public void setBill_amount(String bill_amount) {
    this.bill_amount = bill_amount;
  }

  public String getCredit() {
    return credit;
  }

  public void setCredit(String credit) {
    this.credit = credit;
  }

  public String getQubag_money() {
    return qubag_money;
  }

  public void setQubag_money(String qubag_money) {
    this.qubag_money = qubag_money;
  }

  public int getCust_id() {
    return cust_id;
  }

  public void setCust_id(int cust_id) {
    this.cust_id = cust_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone_no() {
    return phone_no;
  }

  public void setPhone_no(String phone_no) {
    this.phone_no = phone_no;
  }

  public String getAlternate_contact() {
    return alternate_contact;
  }

  public void setAlternate_contact(String alternate_contact) {
    this.alternate_contact = alternate_contact;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCreated_date() {
    return created_date;
  }

  public void setCreated_date(String created_date) {
    this.created_date = created_date;
  }
}
