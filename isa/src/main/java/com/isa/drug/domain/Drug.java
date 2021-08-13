package com.isa.drug.domain;

import com.isa.drug.domain.enums.DrugClass;
import com.isa.drug.domain.enums.DrugForm;
import com.isa.drug.domain.enums.DrugType;
import com.isa.drug.domain.enums.PrescriptionType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "drug_ingredient",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Ingredient> ingredients;


    private String contraindications;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "substitute_drugs",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "substitute_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Drug> substituteDrugs;

    public Drug(Long id, String code, String composition, String manufacturer, String note, DrugForm form, PrescriptionType prescriptionType, DrugType type, DrugClass drugClass, String dailyDose, String name, Integer loyaltyPoints, Set<Ingredient> ingredients, String contraindications, Set<Drug> substituteDrugs) {
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
        this.ingredients = ingredients;
        this.contraindications = contraindications;
        this.substituteDrugs = substituteDrugs;
    }

    public Drug() {

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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public Set<Drug> getSubstituteDrugs() {
        return substituteDrugs;
    }

    public void setSubstituteDrugs(Set<Drug> substituteDrugs) {
        this.substituteDrugs = substituteDrugs;
    }
}
