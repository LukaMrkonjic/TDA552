package TransportApplication;
import TransportModel.Vehicle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Each step the TimerListener moves all the cars in the list and tells the
 * view to update its images. Change this method to your needs.
 *
 */

/*
private class TimerListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        //TODO: ingen logik i observer!

        for (Vehicle car : vehicles) {
            car.move();

            if (car.isOutOfBounds(frame.getDrawPanel().getSize())) {
                car.invertDirection();
                car.move();
                car.move();
            }
            // TODO This adds the cars every tick!!!!!!!!!!!!
            // TODO This makes the program slower and slower until it eventually
            // TODO Runs out of memory and crashes. Fix.

            frame.getDrawPanel().getVehiclesToBeDrawn().add(car);
        }
        // repaint() calls the paintComponent method of the panel
        frame.getDrawPanel().repaint();
    }
}
*/