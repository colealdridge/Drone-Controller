# Drone-Controller
This is a controller designed for the Parrot ARDrone online simulator. It sends instructions as JSON messages based on the controls the application user is sending.
The robot is able to move in four of the six dimensions. A positive linear xnumber tells the
robot to move forward, negative means backward. Linear y is the left/right dimension, and linear z
is the up/down (altitude) dimension. All of these values are in meters/second. A positive angular
zvelocity means rotate to the left, negative means to the right, in radians per second. Although
movement messages also contain fields for angular x(roll) and angular y(pitch), this particular
robot cannot rotate freely around those axes, so those fields are always 0.
