/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cs230.dao;

import com.cs230.entities.Koncert;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Milan
 */
public interface IKoncertDAO {
    public List<Koncert> getList();
}
