package simulator.data;

import lombok.Data;

import java.io.Serializable;

@Data
public class Move implements Serializable {
    private int stepWide;
    private int key;
    public int x;
    public int y;
    
    /*
    x+ = nach rehts gehen
    x- = nach links gehen
    y+ = nach unten gehen
    y- = nach oben gehen
    */

    public Move(int key, int stepWide) {
        this.key = key;
        this.stepWide = stepWide;
        switch (key) {
            case 1:
                this.x = -stepWide;
                this.y = stepWide;
                break;
            case 2:
                this.x = 0;
                this.y = stepWide;
                break;
            case 3:
                this.x = stepWide;
                this.y = stepWide;
                break;
            case 4:
                this.x = -stepWide;
                this.y = 0;
                break;
            case 5:
                this.x = 0;
                this.y = 0;
                break;
            case 6:
                this.x = stepWide;
                this.y = 0;
                break;
            case 7:
                this.x = -stepWide;
                this.y = -stepWide;
                break;
            case 8:
                this.x = 0;
                this.y = -stepWide;
                break;
            case 9:
                this.x = stepWide;
                this.y = -stepWide;
                break;
        }
    }
}
