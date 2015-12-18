package com.mobily.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * The persistent class for the theme_category database table.
 * 
 */
@Entity
@Table(name = "theme_category", uniqueConstraints = { @UniqueConstraint(columnNames = { "category_id" }) })
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NamedQuery(name = "ThemeCategory.findAll", query = "SELECT t FROM ThemeCategory t")
public class ThemeCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private long categoryId;

	private String description;

	private String name;

	// bi-directional many-to-one association to Theme
	// @OneToMany(mappedBy="themeCategory")
	@OneToMany(mappedBy = "themeCategory", fetch = FetchType.EAGER)
	@Column(nullable = true)
	@JsonManagedReference
	@JsonBackReference
	private Set<Theme> themes;

	// bi-directional many-to-one association to ThemeCategory
	@ManyToOne
	@JoinColumn(name = "parent_category_id", nullable=true)
	@JsonBackReference
	private ThemeCategory parentThemeCategory;

/*	// bi-directional many-to-one association to ThemeCategory
	// @OneToMany(mappedBy="themeCategory")
	@OneToMany(mappedBy = "parentThemeCategory", fetch = FetchType.EAGER)
	@Column(nullable = true)
	@JsonManagedReference
	private Set<ThemeCategory> themeCategories;
*/
	public ThemeCategory() {
	}

	public long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Theme> getThemes() {
		return this.themes;
	}

	public void setThemes(Set<Theme> themes) {
		this.themes = themes;
	}

	public Theme addTheme(Theme theme) {
		getThemes().add(theme);
		theme.setThemeCategory(this);

		return theme;
	}

	public Theme removeTheme(Theme theme) {
		getThemes().remove(theme);
		theme.setThemeCategory(null);

		return theme;
	}

	public ThemeCategory getThemeCategory() {
		return this.parentThemeCategory;
	}

	public void setThemeCategory(ThemeCategory parentThemeCategory) {
		this.parentThemeCategory = parentThemeCategory;
	}

/*	public Set<ThemeCategory> getThemeCategories() {
		return this.themeCategories;
	}

	public void setThemeCategories(Set<ThemeCategory> themeCategories) {
		this.themeCategories = themeCategories;
	}
*/
/*	public ThemeCategory addThemeCategory(ThemeCategory themeCategory) {
		getThemeCategories().add(themeCategory);
		themeCategory.setThemeCategory(this);

		return themeCategory;
	}

	public ThemeCategory removeThemeCategory(ThemeCategory themeCategory) {
		getThemeCategories().remove(themeCategory);
		themeCategory.setThemeCategory(null);

		return themeCategory;
	}
*/
}