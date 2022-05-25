package com.example.test_sysco.pojo;

import com.example.test_sysco.pojo.Planets;

import java.util.ArrayList;

public class ResponseBean {

    private String next;

    private String count;

    private ArrayList<Planets> results;

    public String getNext ()
    {
        return next;
    }

    public void setNext (String next)
    {
        this.next = next;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public ArrayList<Planets> getResults ()
    {
        return results;
    }

    public void setResults (ArrayList<Planets> results)
    {
        this.results = results;
    }
}



