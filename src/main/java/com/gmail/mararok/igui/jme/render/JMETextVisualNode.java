/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.render;

/*import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

import com.gmail.mararok.igui.render.Glyph;
import com.gmail.mararok.igui.render.MemoryMesh;*/
import com.gmail.mararok.igui.render.QuadMemoryMesh;
import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.spi.render.TextVisualNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
/*import com.jme3.scene.Mesh.Mode;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.util.BufferUtils;*/

class JMETextVisualNode extends JMEVisualNode implements TextVisualNode {
	private JMEFont font;
	private RGBAColor color = RGBAColor.WHITE;
	private String text = "";
	
	private QuadMemoryMesh[] memoryMeshes;
	
	JMETextVisualNode(String id, RenderDevice renderDevice) {
		super(renderDevice);
		spatial = new Geometry(id,new Mesh());
		spatial.setMaterial(((JMERenderDevice)(renderDevice)).getDefaultMaterial());
	}
	
	@Override
	public Font getFont() {
		return font;
	}

	@Override
	public void setFont(Font newFont) {
		font = (JMEFont)newFont;
		spatial.setMaterial(font.getFontMaterial());
		setText(getText());
	}

	@Override
	public RGBAColor getColor() {
		return color;
	}

	@Override
	public void setColor(RGBAColor newColor) {
		color = newColor;
		setText(getText());
	}

	@Override
	public void setColor(float red, float green, float blue) {
		setColor(new RGBAColor(red,green,blue));
		setText(getText());
	}

	@Override
	public void setText(String newText) {
		/*text = newText;
		if (text == "" || text == null) {
			memoryMeshes = null;
			return;
		}
		
		char[] chars = newText.toCharArray();
		memoryMeshes = new QuadMemoryMesh[chars.length];
		
		QuadMemoryMesh charMesh;
		Glyph glyph;
		
		float uMin,vMin;
		float uMax,vMax;
		int len = memoryMeshes.length;
		int lastCharOffset = 0;
		for (int i = 0; i < len; ++i) {
			charMesh = new QuadMemoryMesh();
			glyph = font.getGlyph(chars[i]);
			//charMesh.translateLocal(lastCharOffset+glyph.getWidth(),0f,0f);
			//charMesh.scaleLocal(glyph.getWidth()/2,glyph.getHeight()/2,1);
			lastCharOffset += glyph.getWidth();
			uMin = glyph.getUMinTexture();
			vMin = glyph.getVMinTexture();
			uMax = glyph.getUMaxTexture();
			vMax = glyph.getVMaxTexture();
			
			charMesh.setTextureCoordinates(new float[] {
					0,0,
					0,1,
					1,1,
					1,0
					uMax,vMax,
					uMin,vMin,
					uMax,vMin,
					uMin,vMax
			});
			
			charMesh.setColors(getColor());
			memoryMeshes[i] = charMesh;
		}
		
		updateGeometry();*/
	}

	@Override
	public String getText() {
		return text;
	}

	/*private void updateGeometry() {
		Mesh realMesh = getGeometry().getMesh();
		
		FloatBuffer positionBuffer = BufferUtils.createFloatBuffer(
			getText().length()*MemoryMesh.VERTEX_COMPONENT_COUNT*MemoryMesh.QUAD_VERTEX_COUNT);
		
		FloatBuffer colorBuffer = BufferUtils.createFloatBuffer(
				getText().length()*MemoryMesh.COLOR_COMPONENT_COUNT*MemoryMesh.QUAD_VERTEX_COUNT);
		
		FloatBuffer texCoordBuffer = BufferUtils.createFloatBuffer(
				getText().length()*2*MemoryMesh.QUAD_VERTEX_COUNT);
		
		ShortBuffer indexBuffer = BufferUtils.createShortBuffer(getText().length()*6);
		
		int currentIndexOffset = 0;
		for (QuadMemoryMesh memoryMesh : memoryMeshes) {
			positionBuffer.put(memoryMesh.getVeritces());
			
			System.out.print("V: ");
			System.out.println(Arrays.toString(memoryMesh.getVeritces()));
			
			colorBuffer.put(memoryMesh.getColors());
			
			System.out.print("C: ");
			System.out.println(Arrays.toString(memoryMesh.getColors()));
			
			texCoordBuffer.put(memoryMesh.getTextureCooridnates());
			System.out.print("T: ");
			System.out.println(Arrays.toString(memoryMesh.getTextureCooridnates()));
			
			short[] indexes = memoryMesh.getIndexes();
			System.out.print("I: ");
			for (int j = 0; j < indexes.length; ++j) {
				indexBuffer.put((short)(indexes[j]+currentIndexOffset));
				System.out.print((short)(indexes[j]+currentIndexOffset));
				System.out.print(" ");
			}
			System.out.println();
			currentIndexOffset += 4;
		}

		realMesh.setBuffer(Type.Position,3,positionBuffer);
		realMesh.setBuffer(Type.Color,4,colorBuffer);
		realMesh.setBuffer(Type.TexCoord,2,texCoordBuffer);
		realMesh.setBuffer(Type.Index,1,indexBuffer);
		realMesh.setMode(Mode.TriangleStrip);
		setScale(300,60,1);
	}*/
	
	Geometry getGeometry() {
		return (Geometry)spatial;
	}
}
