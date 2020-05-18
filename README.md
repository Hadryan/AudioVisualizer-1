# Music Visualizer Project

Name: Mikael Escolin
Student Number: C18366453

# Description of the assignment

For the assignment we had to create something to watch while listening
to music. It could have been a game, audio visualizer, anything that
would involve music.

I decided to do an audio visualizer

# Instructions

Just run comprun.sh and it will compile and run the project.
Press spacebar to start or reset music.

# How it works

I decided to create a three folder architecture. Main, Controller and
Visuals.

## Main

The program starts in main and calls a function to start the visualizer.

## Controller

This folder contained files that controlled how the music or visuals
were handled.

AudioController was created which extended processing.core.PApplet. It
contains functions that would load the song, play the song, calculate
amplitude, etc.

AudioException contained the exception class for AudioController.

VisualController controlled what visuals were on the screen. It created
objects from the Visuals folder and ran them.

## Visuals

### Background

Background was is a visual which drew the triangle background. I wanted
to create the look of being inside a triangular shaped room. For
example, being inside a triangular prism.

I used custom shapes to create the walls as I intended to put a linear
gradient on it which I could not create in the end.

The triangles respondes to the music's amplitude. Once it reached a
certain amplitude the colorOffset would be increased by the amplitude.
This created an effect of the colors changing according to some
elements to the music. Like in the song used it responded to the
chorus' kick drum.

### Particles

This folder contained the files for the particle system.

In the ParticlesSystem.java file it used vector datatype to hold.
all the particles. It would draw call the display function of each
particle every loop. It also checked if the particle was dead and if it
was it would remove the particle from the vector and add a new one.

The addParticle function creates a particle of random x-coordinate at
the bottom of the screen with a random acceleration.

ParticlesSystem.java also handled the response of each particle to the
music's amplitude. It would increase the particles acceleration and
then slow it down again.

Each particle was created using the Particle class. The particle class
had two Pvectors. One for the position and one for the acceleration.
The particle's position and acceleration was randomized by
ParticlesSystem class. It's life, width and amplitude was randomized at
the start as well.

The amplitude in Particle.java is not the audio amplitude but the
amplitude of it's path which it followed using the sine wave
equation. However, the sine wave was to constant so at every 60
frames I would create another random amplitude. This create a more
sporadic movement.

To draw a particle you would run it's display function.

Particles have a life where when it reaches a certain number it is
considered dead. Life ticks up because of the way the particle is
drawn. When the particle is dead it would turn white before being
removed. If it was full of life it would darker and close to black.
Since it went from black to white, life had to tick up due to how
I implemented the color change.

The particle had to first be updated using it's update function to
update it's state and then it was moved using it's move function.
Particles would always move upwards and sway.

# What I am most proud of

I am most proud of the particle system as I have never done anything
like it before. It took the most time out of everything and I am
pleased with the results.

# Demo

Link to my demo: https://www.youtube.com/watch?v=i41eY9ju2iI
