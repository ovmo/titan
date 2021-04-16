import titan.ProbeSimulatorInterface;
import titan.Vector3dInterface;

public class ProbeSimulator implements ProbeSimulatorInterface {
    @Override
    public Vector3dInterface[] trajectory(Vector3dInterface p0, Vector3dInterface v0, double[] ts) {

        return new Vector3dInterface[0];
    }

    @Override
    public Vector3dInterface[] trajectory(Vector3dInterface p0, Vector3dInterface v0, double tf, double h) {

        // spacecraft.posVec = p0
        // spacecraft velVec = v0
        // new state y, fill with info from planets
        // new solver -> solve(new f, y, tf, h)

        return new Vector3dInterface[0];
    }
}
