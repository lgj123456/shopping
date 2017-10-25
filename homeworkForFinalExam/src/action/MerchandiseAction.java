package action;

import java.util.List;

import entity.Merchandise;

import service.IMerchandiseService;


public class MerchandiseAction {
	private IMerchandiseService merchandiseService;// ��Ʒ����ҵ����ӿ�
	private Merchandise merchandise;// ��Ϊ�����Ķ���
	private List<Merchandise> merchandises;// ��ѯ���
	private String finish_Url;// ���������ת�ĵ�ַ
	private String[] merchandiseId;// Ҫɾ����Ʒ��Id

	/**
	 * ��Ʒ������ѯ
	 * 
	 * @return
	 */
	public String findMerchandise() {
		merchandises = merchandiseService.findMerchandise(merchandise);
		return "findMerchandise";
	}

	/**
	 * ���ݱ�Ų�ѯ��Ʒ����
	 * 
	 * @param code
	 * @return
	 */
	public int findMerchandiseByCode(String code) {
		merchandise = new Merchandise();
		merchandise.setCode(code);
		merchandises = merchandiseService.findMerchandise(merchandise);
		return merchandises.size();
	}

	/**
	 * ������Ʒ����
	 * 
	 * @return
	 */
	public String saveMerchandise() {
		merchandiseService.saveMerchandise(merchandise);
		// ��ӳɹ�ҳ����ʾ�����ת��ҳ�棬��ʾMerchandise����������Ϣ
		finish_Url = "merchandiseAction!findMerchandise.action";
		merchandise = null;
		return "finish";
	}

	/**
	 * ��Ʒ��������ǰ��ѯ
	 * 
	 * @return
	 */
	public String preUpdateMerchandise() {
		merchandise = merchandiseService.findMerchandise(merchandise).get(0);
		return "updateMerchandise";
	}

	/**
	 * ��Ʒ��������
	 * 
	 * @return
	 */
	public String updateMerchandise() {
		merchandiseService.updateMerchandise(merchandise);
		// ���³ɹ�ҳ����ʾ�����ת��ҳ�棬��ʾMerchandise����������Ϣ
		finish_Url = "merchandiseAction!findMerchandise.action";
		merchandise = null;
		return "finish";
	}

	/**
	 * ɾ����Ʒ����
	 * 
	 * @return
	 */
	public String deleteMerchandise() {
		merchandiseService.deleteMerchandise(merchandiseId);
		// ɾ���ɹ�ҳ����ʾ�����ת��ҳ�棬��ʾMerchandise����������Ϣ
		finish_Url = "merchandiseAction!findMerchandise.action";
		return "finish";
	}

	public IMerchandiseService getMerchandiseService() {
		return merchandiseService;
	}

	public void setMerchandiseService(IMerchandiseService merchandiseService) {
		this.merchandiseService = merchandiseService;
	}

	public Merchandise getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}

	public List<Merchandise> getMerchandises() {
		return merchandises;
	}

	public void setMerchandises(List<Merchandise> merchandises) {
		this.merchandises = merchandises;
	}

	public String getFinish_Url() {
		return finish_Url;
	}

	public void setFinish_Url(String finish_Url) {
		this.finish_Url = finish_Url;
	}

	public String[] getMerchandiseId() {
		return merchandiseId;
	}

	public void setMerchandiseId(String[] merchandiseId) {
		this.merchandiseId = merchandiseId;
	}

}
