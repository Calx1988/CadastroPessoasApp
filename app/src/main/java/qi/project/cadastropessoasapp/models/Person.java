package qi.project.cadastropessoasapp.models;

public class Person {
    String cpf;
    String name;
    String socialName;
    String gender;
    Double income;
    String fatherCpf;
    String motherCpf;

    public Person(){

    }
    public Person(String cpf, String name, String gender) {
        this.cpf = cpf;
        this.name = name;
        this.gender = gender;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getFatherCpf() {
        return fatherCpf;
    }

    public void setFatherCpf(String fatherCpf) {
        this.fatherCpf = fatherCpf;
    }

    public String getMotherCpf() {
        return motherCpf;
    }

    public void setMotherCpf(String motherCpf) {
        this.motherCpf = motherCpf;
    }

    @Override
    public String toString() {
        return  "\nNome: " + name +
                "\nCPF: " + cpf +
                "\nGênero: " + gender +
                "\nRenda Mensal: R$" + String.format("%.2f", income);
    }
}
