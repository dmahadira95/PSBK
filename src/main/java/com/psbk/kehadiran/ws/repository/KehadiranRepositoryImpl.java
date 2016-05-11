/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.repository;

import com.psbk.kehadiran.ws.domain.Kehadiran;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Denny
 */
@Repository
public class KehadiranRepositoryImpl implements KehadiranRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Kehadiran kehadiran) {
        sessionFactory.getCurrentSession().save(kehadiran);
    }

    @Override
    public void update(Kehadiran kehadiran) {
        sessionFactory.getCurrentSession().update(kehadiran);
    }

    @Override
    public void delete(Kehadiran kehadiran) {
        sessionFactory.getCurrentSession().delete(kehadiran);
    }

    @Override
    public Kehadiran getKehadiran(int idKehadiran) {
        return sessionFactory.getCurrentSession().get(Kehadiran.class, idKehadiran);
    }

    @Override
    public List<Kehadiran> getKehadirans() {
        return sessionFactory.getCurrentSession().createCriteria(Kehadiran.class).list();
    }

    @Override
    public double getPersentase(int idKehadiran){
        Kehadiran kehadiran = sessionFactory.getCurrentSession().get(Kehadiran.class, idKehadiran);
        int presensiMahasiswa = kehadiran.getPresensiMahasiswa();
        int presensiDosen = kehadiran.getPresensiDosen();
        
        double persentase = ((double) presensiMahasiswa/ (double) presensiDosen) * 100; 

        return persentase;
    }
    
    @Override
    public Kehadiran getDosen(String idDosen){
        return sessionFactory.getCurrentSession().get(Kehadiran.class, idDosen);
    }
}
