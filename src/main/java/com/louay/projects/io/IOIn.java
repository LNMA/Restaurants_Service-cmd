package com.louay.projects.io;

import com.louay.projects.entry.Order;
import com.louay.projects.controller.ReportFile;

import java.io.*;

public class IOIn extends ReportFile {

    public void iOIn() {
        int i = 0;
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("sales.dat")))) {
            while (true) {
                setNewSize();
                sequence[i] = (Order) in.readObject();
                ++i;
            }

        } catch (EOFException e) {
            System.out.print("\n>> all data was read successfully.\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.print("\n>> " + e.getMessage() + "\n");
        }
    }
}
