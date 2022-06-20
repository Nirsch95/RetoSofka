/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tabla;

import DAO.NaveDAO;
import VO.NaveVO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author felix
 */
public class Tabla_NaveVO {
    
    NaveDAO dao = null;
    
    public void visualizar_NaveVO(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("Idnave");
        dt.addColumn("Nombre");
        dt.addColumn("Altura");
        dt.addColumn("Peso");
        dt.addColumn("Tipo");
        dt.addColumn("Fecha Ini");
        dt.addColumn("Fecha Fin");
        dt.addColumn("Foto");

        dao = new NaveDAO();
        NaveVO vo = new NaveVO();
        ArrayList<NaveVO> list = dao.Listar_NaveVO();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[8];
                vo = list.get(i);
                fila[0] = vo.getIdnave();
                fila[1] = vo.getNombre();
                fila[2] = vo.getAltura();
                fila[3] = vo.getPeso();
                fila[4] = vo.getTipo();
                fila[5] = vo.getFini();
                fila[6] = vo.getFfin();
                try{
                    byte[] bi = vo.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[7] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[7] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
    
}
