package com.mobily.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the theme_category database table.
 * 
 */
@Entity
@Table(name="theme_category")
@NamedQuery(name="ThemeCategory.findAll", query="SELECT t FROM ThemeCategory t")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ThemeCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id", unique=true, nullable=false)
	private long categoryId;

/*	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
	private Date createDate;
*/
	@Column(length=1000)
	private String description;

/*	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
*/
	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Theme
	//@OneToMany(mappedBy="themeCategory")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="theme", joinColumns={@JoinColumn(name="category_id", referencedColumnName="category_id")}, inverseJoinColumns={@JoinColumn(name="theme_id", referencedColumnName="theme_id")})
	private List<Theme> themes;

	//bi-directional many-to-one association to ThemeCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_category_id")
	private ThemeCategory themeCategory;

	//bi-directional many-to-one association to ThemeCategory
	@OneToMany(mappedBy="themeCategory")
	private List<ThemeCategory> themeCategories;

	public ThemeCategory() {
	}

	public long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

/*	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
*/
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

/*	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Theme> getThemes() {
		return this.themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public Theme addTheme(Theme theme) {
		getThemes().add(theme);
//		theme.setThemeCategory(this);

		return theme;
	}

	public Theme removeTheme(Theme theme) {
		getThemes().remove(theme);
//	theme.setThemeCategory(null);

		return theme;
	}

	public ThemeCategory getThemeCategory() {
		return this.themeCategory;
	}

	public void setThemeCategory(ThemeCategory themeCategory) {
		this.themeCategory = themeCategory;
	}

	public List<ThemeCategory> getThemeCategories() {
		return this.themeCategories;
	}

	public void setThemeCategories(List<ThemeCategory> themeCategories) {
		this.themeCategories = themeCategories;
	}

	public ThemeCategory addThemeCategory(ThemeCategory themeCategory) {
		getThemeCategories().add(themeCategory);
		themeCategory.setThemeCategory(this);

		return themeCategory;
	}

	public ThemeCategory removeThemeCategory(ThemeCategory themeCategory) {
		getThemeCategories().remove(themeCategory);
		themeCategory.setThemeCategory(null);

		return themeCategory;
	}

}