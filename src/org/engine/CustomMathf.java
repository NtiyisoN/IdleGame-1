package org.engine;

import java.util.Random;

public class CustomMathf
{
    public static float NineAxisRotation(float rotValue, float hori, float vert, float speed, float deltaTime)
    {
        deltaTime = deltaTime * speed;

        // RIGHT

        if(hori > 0 && vert == 0)
        {
            rotValue = Lerp(rotValue, 0, deltaTime);
        }

        if(hori > 0 && vert > 0)
        {
            rotValue = Lerp(rotValue, -45, deltaTime);
        }

        if(hori > 0 && vert < 0)
        {
            rotValue = Lerp(rotValue, 45, deltaTime);
        }

        // LEFT

        if(hori < 0 && vert == 0)
        {
            rotValue = Lerp(rotValue, 180, deltaTime);
        }

        if(hori < 0 && vert > 0)
        {
            rotValue = Lerp(rotValue, 225, deltaTime);
        }

        if(hori < 0 && vert < 0)
        {
            rotValue = Lerp(rotValue, 135, deltaTime);
        }

        // UP

        if(vert > 0 && hori == 0)
        {
            rotValue = Lerp(rotValue, -90, deltaTime);
        }

        if(vert > 0 && hori > 0)
        {
            rotValue = Lerp(rotValue, -45, deltaTime);
        }

        if(vert > 0 && hori < 0)
        {
            rotValue = Lerp(rotValue, 225, deltaTime);
        }

        // DOWN

        if(vert < 0 && hori == 0)
        {
            rotValue = Lerp(rotValue, 90, deltaTime);
        }

        if(vert < 0 && hori > 0)
        {
            rotValue = Lerp(rotValue, 45, deltaTime);
        }

        if(vert < 0 && hori < 0)
        {
            rotValue = Lerp(rotValue, 135, deltaTime);
        }

        return rotValue;
    }

    public static int randInt(int min, int max)
    {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static float Clamp(float var, float min, float max)
    {
        if(var>= max)
        {
            return var = max;
        }
        else if (var <= min)
        {
            return var = min;
        }
        else
        {
            return var;
        }
    }

    public static float Lerp(float a, float b, float t)
    {
        return a + t * (b - a);
    }

    public static float Slerp(float a, float b, float t)
    {
        float dot = a * b;
        dot = Clamp(dot, -1.0f, 1.0f);
        float theta = (float)(Math.acos(dot) * t);
        float relative = b - a * dot;
        float normalized = (relative - (-1))/((-1)-1);
        return (float)((a * Math.cos(theta)) + ((normalized * Math.sin(theta))));
    }
}