import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.json.JSONArray;
import org.json.JSONObject;
public class frontend extends javax.swing.JFrame {

        public frontend() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Weather App");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(33, 27, 251, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter The City -");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 110, 176, 42);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(240, 110, 192, 42);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 180, 80, 30);

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(608, 27, 100, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 230, 195, 68);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 230, 105, 68);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 280, 288, 70);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(490, 260, 220, 40);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jLabel8);
        jLabel8.setBounds(490, 300, 210, 40);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 280, 120, 100);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 740, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO a:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
             try{
            String str = jTextField1.getText();
            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();
            URL url=new URL("https://api.weatherbit.io/v2.0/current?city=" +str+ "&key=4eab8624ee66465080954cf8252bee99");
            System.out.println(url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status=connection.getResponseCode();
            if (status>299)
            {
                reader= new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line=reader.readLine())!=null)
                {
                    responseContent.append(line);
                }
                reader.close();
            }
            else
            {
                reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line=reader.readLine())!=null)
                {
                     responseContent.append(line);
                }
                reader.close();
            }
            String resp = responseContent.toString();
            System.out.println(resp);
            //System.out.println(status);
            JSONObject obj=new JSONObject(resp);
            JSONArray data=obj.getJSONArray("data");
            //Reading data
                JSONObject info=data.getJSONObject(0);
                float temp=info.getFloat("temp");
                float precip=info.getFloat("precip");
                float wind=info.getFloat("wind_spd");
                String city_name=info.getString("city_name");
                JSONObject  weather = info.getJSONObject("weather");
                String description = weather.getString("description");
                String icon = weather.getString("icon");
                System.out.println(icon);
                URL url2 = new URL("https://www.weatherbit.io/static/img/icons/"+icon+".png");
                BufferedImage img1 = ImageIO.read(url2);
                //To access the Json Object weather inside the main json array data
                System.out.println(description);
                System.out.println(city_name);
                System.out.println(temp);
                jLabel3.setText("Temperature -");
                jLabel4.setText(String.valueOf(temp));
                jLabel5.setText(description);
                jLabel7.setText("Precitipation: "+precip);
                jLabel8.setText("Wind Speed: "+wind+"m/s");
                jLabel9.setIcon(new ImageIcon(img1));
                
                //  System.out.println(temp+"           "+city);
            

        }   catch (MalformedURLException ex) {
            Logger.getLogger(Uievent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Uievent.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frontend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
