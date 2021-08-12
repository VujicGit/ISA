package com.isa.drug.domain;

import com.isa.appointment.domain.Appointment;
import com.isa.drug.domain.enums.DrugClass;
import com.isa.drug.domain.enums.DrugForm;
import com.isa.drug.domain.enums.DrugType;
import com.isa.drug.domain.enums.PrescriptionType;
import com.isa.pharmacy.domain.Item;
import com.isa.pharmacy.domain.Price;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private String composition;

    @Column
    private String manufacturer;

    @Column
    private String note;

    @Column
    private DrugForm form;

    @Column
    private PrescriptionType prescriptionType;

    @Column
    private DrugType type;

    @Column
    private DrugClass drugClass;

    @Column
    private String dailyDose;

    @Column
    private String name;

    @Column
    private Integer loyaltyPoints;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Allergy allergy;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Price price;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private com.isa.pharmacy.domain.Item Item;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "drug_ingredient",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Ingredient> ingredients;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "drug_contraindication",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "contraindication_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Contraindication> contraindications;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "substitute_drugs",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "substitute_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Drug> substituteDrugs;

    public Drug() {
    }

    public Drug(Long id, String code, String composition, String manufacturer, String note, DrugForm form,
                PrescriptionType prescriptionType, DrugType type, DrugClass drugClass, String dailyDose, String name,
                Integer loyaltyPoints, Allergy allergy, Price price, com.isa.pharmacy.domain.Item item,
                List<Ingredient> ingredients, List<Contraindication> contraindications, List<Drug> substituteDrugs) {
        this.id = id;
        this.code = code;
        this.composition = composition;
        this.manufacturer = manufacturer;
        this.note = note;
        this.form = form;
        this.prescriptionType = prescriptionType;
        this.type = type;
        this.drugClass = drugClass;
        this.dailyDose = dailyDose;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
        this.allergy = allergy;
        this.price = price;
        Item = item;
        this.ingredients = ingredients;
        this.contraindications = contraindications;
        this.substituteDrugs = substituteDrugs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public DrugForm getForm() {
        return form;
    }

    public void setForm(DrugForm form) {
        this.form = form;
    }

    public PrescriptionType getPrescriptionType() {
        return prescriptionType;
    }

    public void setPrescriptionType(PrescriptionType prescriptionType) {
        this.prescriptionType = prescriptionType;
    }

    public DrugType getType() {
        return type;
    }

    public void setType(DrugType type) {
        this.type = type;
    }

    public DrugClass getDrugClass() {
        return drugClass;
    }

    public void setDrugClass(DrugClass drugClass) {
        this.drugClass = drugClass;
    }

    public String getDailyDose() {
        return dailyDose;
    }

    public void setDailyDose(String dailyDose) {
        this.dailyDose = dailyDose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Contraindication> getContraindications() {
        return contraindications;
    }

    public void setContraindications(List<Contraindication> contraindications) {
        this.contraindications = contraindications;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public com.isa.pharmacy.domain.Item getItem() {
        return Item;
    }

    public void setItem(com.isa.pharmacy.domain.Item item) {
        Item = item;
    }

    public List<Drug> getSubstituteDrugs() {
        return substituteDrugs;
    }

    public void setSubstituteDrugs(List<Drug> substituteDrugs) {
        this.substituteDrugs = substituteDrugs;
    }
}
