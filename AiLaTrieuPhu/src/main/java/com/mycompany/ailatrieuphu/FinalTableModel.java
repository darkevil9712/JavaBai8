/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ailatrieuphu;

import com.mycompany.ailatrieuphu.DTO.LinhVucDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nguyen.vu
 */
public class FinalTableModel extends AbstractTableModel {

    private List<LinhVucDTO> list = new ArrayList<>();
    private String[] columnNames = { "ID", "Name"};

    public FinalTableModel(List<LinhVucDTO> list){
         this.list = list;
    }

    @Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }

    @Override     
    public int getRowCount() {
        return list.size();
    }

    @Override        
    public int getColumnCount() {
        return 2; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LinhVucDTO si = list.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return si.getId();
            case 1:
                return si.getName();
            
           }
           return null;
   }

   @Override
   public Class<?> getColumnClass(int columnIndex){
          switch (columnIndex){
             case 0:
               return Integer.class;
             case 1:
               return String.class;
             
             }
             return null;
      }
 }