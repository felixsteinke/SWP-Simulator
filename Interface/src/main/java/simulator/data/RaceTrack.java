package simulator.data;

import lombok.Data;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class RaceTrack implements Serializable {

    transient private File input;
    private String name;
    private int widthField;
    private int heightField;
    private int pointsOutter;
    private ArrayList<Point> coordOuter;
    private int pointsInner;
    private ArrayList<Point> coordInner;
    private int distance;
    private ArrayList<Point> coordStart;
    private ArrayList<Point> coordControl;
    private int gridSize;
    private int gapSize;
    private ArrayList<Point> validPoints;
    private ArrayList<Point> startPoints;

    public RaceTrack(File input) {
        this.input = input;
        this.name = input.getName();
        this.validPoints = new ArrayList<Point>();
        this.startPoints = new ArrayList<Point>();
        decode();
    }

    public RaceTrack() {
        this.coordInner = new ArrayList<Point>();
        this.coordOuter = new ArrayList<Point>();
        this.coordStart = new ArrayList<Point>();
        this.coordControl = new ArrayList<Point>();
        this.validPoints = new ArrayList<Point>();
        this.startPoints = new ArrayList<Point>();
    }

    public void exportFile() {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("Client/src/resources/racetracks/" + name + ".csv", true));
            writer.print(dataToString());
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RaceTrack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "RaceTrack: " + name + "\n"
                + widthField + ", " + heightField + "\n"
                + "PointsOut: " + pointsOutter + "\n"
                + coordOuter.toString() + "\n"
                + "PointsIn: " + pointsInner + "\n"
                + coordInner.toString() + "\n"
                + "Distance: " + distance + "\n"
                + "Start: " + coordStart.toString() + "\n"
                + "Control: " + coordControl.toString() + "\n"
                + "Grid: " + gridSize + "\n"
                + "Gap: " + gapSize + "\n"
                + "ValidPoints: " + validPoints + "\n"
                + "StartPoints: " + startPoints.toString();
    }

    public String dataToString() {
        this.pointsOutter = coordOuter.size();
        this.pointsInner = coordInner.size();
        //Build Format String
        StringBuilder csvString = new StringBuilder();
        csvString.append(widthField + "," + heightField + "\n");
        csvString.append(pointsOutter + "\n");
        csvString.append(pointsArraytoString(coordOuter) + "\n");
        csvString.append(pointsInner + "\n");
        csvString.append(pointsArraytoString(coordInner) + "\n");
        csvString.append(distance + "\n");
        csvString.append(pointsArraytoString(coordStart) + "\n");
        csvString.append(pointsArraytoString(coordControl) + "\n");
        csvString.append(pointsArraytoString(startPoints));
        return csvString.toString();
    }

    private String pointsArraytoString(ArrayList<Point> list) {
        StringBuilder arrayString = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            arrayString.append(list.get(i).x + "," + list.get(i).y);
            if (i < list.size() - 1) {
                arrayString.append(",");
            }
        }
        return arrayString.toString();
    }

    private void decode() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            String[] splitLine = lines.get(0).split(",");
            widthField = Integer.parseInt(splitLine[0]);
            heightField = Integer.parseInt(splitLine[1]);
            pointsOutter = Integer.parseInt(lines.get(1));
            coordOuter = createPointArray(lines.get(2), pointsOutter);
            pointsInner = Integer.parseInt(lines.get(3));
            coordInner = createPointArray(lines.get(4), pointsInner);
            distance = Integer.parseInt(lines.get(5));
            calcOnDistance();
            coordStart = createPointArray(lines.get(6), 2);
            if (lines.size() > 7) {
                coordControl = createPointArray(lines.get(7), 2);
            } else {
                coordControl = new ArrayList<Point>();
            }
            if (lines.size() > 8) {
                startPoints = createPointArray(lines.get(8), 5);
            } else {
                startPoints = new ArrayList<Point>();
            }
        } catch (IOException ex) {
            Logger.getLogger(RaceTrack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<Point> createPointArray(String line) {
        ArrayList<Point> points = new ArrayList<Point>();
        String[] split = line.split(",");
        for (int i = 0; i < split.length; i += 2) {
            points.add(createPoint(split[i], split[i + 1]));
        }
        return points;
    }

    private ArrayList<Point> createPointArray(String line, int length) {
        ArrayList<Point> points = new ArrayList<Point>();
        String[] split = line.split(",");
        for (int i = 0; i < (length * 2); i += 2) {
            points.add(createPoint(split[i], split[i + 1]));
        }
        return points;
    }

    private Point createPoint(String x, String y) {
        Point point = new Point();
        point.x = Integer.parseInt(x);
        point.y = Integer.parseInt(y);
        return point;
    }

    public void calcOnDistance() {
        gridSize = (distance / 3) * 2;
        gapSize = (distance / 3);
    }
}
