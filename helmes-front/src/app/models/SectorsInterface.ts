export interface Sector {
  id: number,
  name: string
}

export interface SectorGroup {
  disabled?: boolean;
  name: string;
  sectors: Sector[]
}
