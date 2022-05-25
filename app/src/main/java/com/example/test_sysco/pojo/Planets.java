package com.example.test_sysco.pojo;

public class Planets {

    private String[] films;

    private String edited;

    private String created;

    private String climate;

    private String rotation_period;

    private String url;

    private String population;

    private String orbital_period;

    private String surface_water;

    private String diameter;

    private String gravity;

    private String name;

    private String[] residents;

    private String terrain;

    public String[] getFilms ()
    {
        return films;
    }

    public void setFilms (String[] films)
    {
        this.films = films;
    }

    public String getEdited ()
    {
        return edited;
    }

    public void setEdited (String edited)
    {
        this.edited = edited;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getClimate ()
    {
        return climate;
    }

    public void setClimate (String climate)
    {
        this.climate = climate;
    }

    public String getRotation_period ()
    {
        return rotation_period;
    }

    public void setRotation_period (String rotation_period)
    {
        this.rotation_period = rotation_period;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getPopulation ()
    {
        return population;
    }

    public void setPopulation (String population)
    {
        this.population = population;
    }

    public String getOrbital_period ()
    {
        return orbital_period;
    }

    public void setOrbital_period (String orbital_period)
    {
        this.orbital_period = orbital_period;
    }

    public String getSurface_water ()
    {
        return surface_water;
    }

    public void setSurface_water (String surface_water)
    {
        this.surface_water = surface_water;
    }

    public String getDiameter ()
    {
        return diameter;
    }

    public void setDiameter (String diameter)
    {
        this.diameter = diameter;
    }

    public String getGravity ()
    {
        return gravity;
    }

    public void setGravity (String gravity)
    {
        this.gravity = gravity;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String[] getResidents ()
    {
        return residents;
    }

    public void setResidents (String[] residents)
    {
        this.residents = residents;
    }

    public String getTerrain ()
    {
        return terrain;
    }

    public void setTerrain (String terrain)
    {
        this.terrain = terrain;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [films = "+films+", edited = "+edited+", created = "+created+", climate = "+climate+", rotation_period = "+rotation_period+", url = "+url+", population = "+population+", orbital_period = "+orbital_period+", surface_water = "+surface_water+", diameter = "+diameter+", gravity = "+gravity+", name = "+name+", residents = "+residents+", terrain = "+terrain+"]";
    }
}
