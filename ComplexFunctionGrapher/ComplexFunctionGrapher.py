import numpy as np
import math as mt
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d.proj3d import proj_transform
from mpl_toolkits.mplot3d.axes3d import Axes3D
from matplotlib.patches import FancyArrowPatch
from IPython.display import clear_output
clear_output(wait=True)

###############################################################################
#### Program to graph f:C -> C, where for w in C, we have w = f(z).
###############################################################################
#### Constants:
# The origin
O = [0,0,0]
# For indies of the arrays for arrows
X = 0
Y = 1
Z = 2

###############################################################################
#### Axes functions:
###############################################################################    
    
# Imaginary axis in the pre-image space containing 'z'.   
def IMz():
    return [0,1,0]

# Real axis in the pre-image space containing 'z'. 
def REz():
    return [1,0,0]

# Imaginary axis in the image space containing 'w'.
# 1 unit directly above (z direction) the 'head' of 'z'.
def IMw(z):
    return [z.real, z.imag, 1]

# Real axis in the image space containing 'w'.
# REw = (z cross IMw) + z.
def REw(z):
    return [z.real + z.imag, z.imag - z.real, 0]

###############################################################################
#### Custom Classes:
###############################################################################

# Class for the complex input 'w' for the funtion w = f(z).        
class WOutput:
    def __init__(self, radius, angle, origin):
        self.w = C(radius, angle)
        self.tail = origin
        self.head = [radius * mt.sin(self.w.theta), -radius * mt.cos(self.w.theta), 0]
        
    def W(self):
        return self.w.radius * exp(self.w.theta.j)

# Custom complex class to exploit the form z = r*e^{itheta}.
class C:
    def __init__(self, radius, angle):
        self.r = radius
        self.theta = angle
        
# Class for the complex input 'z' for the function w = f(z).
class ZInput:
    def __init__(self, radius, angle):
        self.z = C(radius, angle)
        self.tail = np.zeros(3)
        self.head = [radius * mt.cos(self.z.theta), radius * mt.sin(self.z.theta), 0]
        
    def Z(self):
        return z.radius * exp(z.theta.j)
    
    def Vec(self):
        return 0;
        

# Class for the complex input 'w' for the funtion w = f(z).        
class WOutput:
    def __init__(self, radius, angle, origin):
        self.w = C(radius, angle)
        self.tail = origin
        self.head = [radius * mt.sin(self.w.theta), -radius * mt.cos(self.w.theta), 0]
        
    def W(self):
        return self.w.radius * exp(self.w.theta.j)
###############################################################################
#### Arrow Stuff:
###############################################################################  
####    Custom Classes:
###############################################################################  

class Arrow3D(FancyArrowPatch):

    def __init__(self, x, y, z, dx, dy, dz, *args, **kwargs):
        super().__init__((0, 0), (0, 0), *args, **kwargs)
        self._xyz = (x, y, z)
        self._dxdydz = (dx, dy, dz)

    def draw(self, renderer):
        x1, y1, z1 = self._xyz
        dx, dy, dz = self._dxdydz
        x2, y2, z2 = (x1 + dx, y1 + dy, z1 + dz)

        xs, ys, zs = proj_transform((x1, x2), (y1, y2), (z1, z2), self.axes.M)
        self.set_positions((xs[0], ys[0]), (xs[1], ys[1]))
        super().draw(renderer)

def _arrow3D(ax, x, y, z, dx, dy, dz, *args, **kwargs):
    '''Add an 3d arrow to an `Axes3D` instance.'''

    arrow = Arrow3D(x, y, z, dx, dy, dz, *args, **kwargs)
    ax.add_artist(arrow)

setattr(Axes3D, 'arrow3D', _arrow3D)

###############################################################################  
####    Custom functions:
###############################################################################  

###############################################################################
#### Test Output:
###############################################################################    

fig = plt.figure(figsize=(7, 7))
ax = fig.add_subplot(111, projection='3d')
ax.set_xlim(-2,2)
ax.set_ylim(-2,2)

for i in range(16):
    theta = (i * mt.pi) / 8
    z = ZInput(1,theta)
    w = WOutput(1, theta, z.head)
    ax.arrow3D(z.tail[X], z.tail[Y], z.tail[Z],
           z.head[X], z.head[Y], z.head[Z],
           mutation_scale=2,
           ec ='red')
    ax.arrow3D(w.tail[X], w.tail[Y], w.tail[Z],
           w.head[X], w.head[Y], w.head[Z],
           mutation_scale=2,
           ec ='green')
    