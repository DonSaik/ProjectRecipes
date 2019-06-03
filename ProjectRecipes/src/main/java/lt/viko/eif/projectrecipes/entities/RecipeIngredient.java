/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.viko.eif.projectrecipes.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author donatas
 */
@Entity
@Table(name = "RecipeIngredient")
@NamedQueries({
    @NamedQuery(name = "RecipeIngredient.findAll", query = "SELECT r FROM RecipeIngredient r")})
public class RecipeIngredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private int amount;
    @JoinColumn(name = "IngredientId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Ingredient ingredient;
    @JoinColumn(name = "RecipeId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Recipe recipe;
    @JoinColumn(name = "Unit", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Unit unit;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Integer id) {
        this.id = id;
    }

    public RecipeIngredient(Integer id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecipeIngredient)) {
            return false;
        }
        RecipeIngredient other = (RecipeIngredient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.viko.eif.projectrecipes.entities.RecipeIngredient[ id=" + id + " ]";
    }
    
}
